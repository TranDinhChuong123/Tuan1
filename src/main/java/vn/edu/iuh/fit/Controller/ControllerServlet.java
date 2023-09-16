package vn.edu.iuh.fit.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.models.GrantAccess;
import vn.edu.iuh.fit.repositories.AccountRepository;
import vn.edu.iuh.fit.repositories.GrantAccessRepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ControllerServlet", urlPatterns = { "/ControllerServlet" })
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action =  req.getParameter("action");


        if(action.equalsIgnoreCase("Login")){
            PrintWriter out = resp.getWriter();
            AccountRepository accountRepository = new AccountRepository();
            Account account= accountRepository.findAccountOfId(req.getParameter("user"),req.getParameter("pass"));


            if(account!=null){
                GrantAccessRepository grantAccessRepository = new GrantAccessRepository();
                GrantAccess grantAccess =grantAccessRepository.findGrantAccessOfId(account.getAccount_id());
                System.out.println(grantAccess.toString());
                if(grantAccess.getRole().getRole_id().equals("admin")){
                    System.out.println(1);

                    List<Account> accountList = accountRepository.getAllAccountList();
                    for (Account account1 : accountList) {
                        System.out.println(account1.toString());

                    }
                    HttpSession session = req.getSession();
                    session.setAttribute("accountList", accountList);
                    req.setAttribute("accountList", accountList);
                    req.getRequestDispatcher("dashboard.jsp").forward(req,resp);
                }else{
                    HttpSession session = req.getSession();
                    session.setAttribute("account", account);
                    req.getRequestDispatcher("Profile.jsp").forward(req,resp);
                }

            }else{
                out.println("dang nhap khong thanh cong ");
            }
        }
    }
}
