package org.example.webapp.bookstore;

import org.osgi.service.component.annotations.Component;

import com.effectiveosgi.annotation.RequireWebComponent;
import osgi.enroute.twitter.bootstrap.capabilities.RequireBootstrapWebResource;
import osgi.enroute.webcomponentsjs.webresource.capabilities.RequireWebcomponentsJSWebresource;
import osgi.enroute.webserver.capabilities.RequireWebServerExtender;

@RequireWebComponent(name = "cart-list")
@RequireWebcomponentsJSWebresource(resource = "webcomponents-lite.min.js")
@RequireBootstrapWebResource(resource="css/bootstrap.css")
@RequireWebServerExtender
@Component
public class BookstoreApp {
}
