package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.example.model.Transfer;
import com.example.util.TransferDBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/edittransfer")
public class EditTransfer extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int tid = Integer.parseInt(request.getParameter("tid"));
        HttpSession session = request.getSession();
        session.setAttribute("tid", tid);
        response.sendRedirect("EditTransaction.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int tid = Integer.parseInt(request.getParameter("tid"));
            String newPurpose = request.getParameter("tpurpose");
            double newAmount = Double.parseDouble(request.getParameter("tamount"));

            boolean updateSuccess = TransferDBUtil.editTransaction(tid, newPurpose, newAmount);

            if (updateSuccess) {
                // Update session attribute with the edited transaction details
                HttpSession session = request.getSession();
                List<Transfer> transactions = (List<Transfer>) session.getAttribute("transactions");
                if (transactions != null) {
                    for (Transfer transaction : transactions) {
                        if (transaction.getTid() == tid) {
                            transaction.setPurpose(newPurpose);
                            transaction.setAmount(newAmount);
                            break;
                        }
                    }
                }
                session.setAttribute("transactions", transactions);

                // Redirect back to pendingTransaction.jsp
                response.sendRedirect("pendingTransaction.jsp");
            } else {
                response.sendRedirect("unsuccess.jsp");
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("error.jsp");
        }
    }

}
