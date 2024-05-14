/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesis.servlets;

import com.thesis.dao.DocumentDao;
import static com.thesis.enrdcr.AesEncryption.encryptFile;
import static com.thesis.enrdcr.AesEncryption.generateIv;
import static com.thesis.enrdcr.AesEncryption.getKeyFromPassword;
import com.thesis.entities.Customer;
import com.thesis.entities.Documents;
import com.thesis.helper.ConnectionProvider;
import com.thesis.helper.Helper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Mangala sharma
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class UplServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String dtitle = request.getParameter("dTitle");
            Part part = request.getPart("dFile");

            HttpSession session = request.getSession();
            Customer user = (Customer) session.getAttribute("currentUser");

            Documents p = new Documents(dtitle, part.getSubmittedFileName(), null, user.getId());
            DocumentDao dao = new DocumentDao(ConnectionProvider.getConnection());

            if (dao.uploadFile(p)) {
                String ipath = request.getSession().getServletContext().getRealPath("/")
                        + "Fil_es" + File.separator + part.getSubmittedFileName();
                String opath = request.getSession().getServletContext().getRealPath("/")
                        + "en_cryptfile" + File.separator + part.getSubmittedFileName();

                File inputFile = new File(ipath);
                File outputFile = new File(opath + ".encrypted");

                /*// Generate a secret key
            SecretKey key = generateKey(128);

            // Generate an initialization vector (IV)
             IvParameterSpec iv = generateIv();

            // Encrypt the file
            encryptFile("AES/CBC/PKCS5Padding", key, iv, inputFile, outputFile);*/
                SecretKey key = getKeyFromPassword("password", "salt");
                IvParameterSpec iv = generateIv();
                encryptFile("AES/CBC/PKCS5Padding", key, iv, inputFile, outputFile);

                // Save the encrypted file
                boolean saved = Helper.saveFile(new FileInputStream(outputFile), opath + ".encrypted");

                if (saved) {
                    out.println("done");
                    out.println(opath + ".encrypted");

                } else {
                    out.println("error");
                }
            } else {
                out.println("error");
            }
        }
    }
//          Helper.saveFile(part.getInputStream(),path);
//              
//              out.println("done");
//              out.println(path);
//              
//          }else{
//              out.println("error");
//          }
//        }        
//                

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UplServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(UplServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(UplServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(UplServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(UplServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(UplServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(UplServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UplServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(UplServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(UplServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(UplServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(UplServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(UplServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(UplServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
