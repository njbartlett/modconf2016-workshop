package org.example.webcomp.cart;

import static org.osgi.service.http.whiteboard.HttpWhiteboardConstants.HTTP_WHITEBOARD_RESOURCE_PATTERN;
import static org.osgi.service.http.whiteboard.HttpWhiteboardConstants.HTTP_WHITEBOARD_RESOURCE_PREFIX;
import static org.osgi.service.http.whiteboard.HttpWhiteboardConstants.HTTP_WHITEBOARD_SERVLET_PATTERN;

import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.cart.Cart;
import org.example.cart.CartEntry;
import org.example.cart.CartManager;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import osgi.enroute.http.capabilities.RequireHttpImplementation;

@Component(
    property = {
      HTTP_WHITEBOARD_SERVLET_PATTERN + "=/cart-list/servlet/*",
      HTTP_WHITEBOARD_RESOURCE_PATTERN + "=/cart-list/*",
      HTTP_WHITEBOARD_RESOURCE_PREFIX + "=/cart-list"
    })
@RequireHttpImplementation
public class CartServlet extends HttpServlet implements Servlet {

  private static final long serialVersionUID = 1L;
  
  @Reference
  private CartManager manager;

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try (PrintStream out = new PrintStream(response.getOutputStream())) {
      Cart cart = manager.getCart("anonymous");

      StringBuilder builder = new StringBuilder();
      builder.append("[");
      int row = 0;
      for (CartEntry entry : cart.listEntries()) {
        if (row++ > 0) builder.append(',');
        builder.append(String.format("{\"sku\" : \"%s\", \"price\" : %d}", entry.getSku(), entry.getSoldPrice()));
      }
      builder.append("]");
      response.setHeader("Content-Type", "application/json");
      out.print(builder.toString());
      out.flush();
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}