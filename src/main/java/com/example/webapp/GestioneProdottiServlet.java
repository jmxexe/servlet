package com.example.webapp;

import java.io.*;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Carrello;
import model.Prodotto;

@WebServlet(name = "GestioneProdottiServlet", value = "/Gestione-prodotti")
public class GestioneProdottiServlet extends HttpServlet {

    private Carrello carrello = new Carrello();
    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        Enumeration values = request.getParameterNames();
        while(values.hasMoreElements()){
            String name = (String) values.nextElement();
            String[] value = request.getParameterValues(name);
            out.println("<h2>array value </h2>");
            for(String v : value) {
                out.println("<p>" + name +": "+ v +" </p> <br>");
            }

        }


        if(request.getParameter("nomeProdottoDaEliminare") == null) {
            boolean aggiunto = carrello.aggiungiProdotto(new Prodotto(request.getParameter("nomeProdotto"),request.getParameter("descrizione")));

            //out.println("<h1> info prodotto inviato: </h1> <p>" + request.getParameter("nomeProdotto") + " " + request.getParameter("descrizione") + "</p>");

            out.println("<br> <h1>situazione carrello</h1>");
            for (Prodotto p : carrello.getCarrello()) {
                out.println("<p> " + p.toString() + "</p> <br>");
            }
            if(aggiunto) {
                out.println("<h2>aggiunto con successo!</h2>");
            } else {
                out.println("<h2>errore nell'inserimento!</h2>");
            }
        }
        else {
            boolean eliminato = carrello.eliminaProdotto(request.getParameter("nomeProdottoDaEliminare"));

            out.println("<br> <h1>situazione carrello</h1>");
            for (Prodotto p : carrello.getCarrello()) {
                out.println("<p> " + p.toString() + "</p> <br>");
            }
            if(eliminato) {
                out.println("<h2> eliminato con successo</h2>");
            } else {
                out.println("<h2> errore nell'eliminazione </h2>");
            }
        }

        out.println("<a href='http://localhost:8080/webApp_war_exploded/gestioneProdotto.html'>ritorna al form</a> </body></html>");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request,response);
    }

//    @Override
//    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doDelete(req, resp);
//    }

    public void destroy() {
    }
}