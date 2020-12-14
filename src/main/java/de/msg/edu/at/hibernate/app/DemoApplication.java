package de.msg.edu.at.hibernate.app;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Defines the entry point of the demo application.
 */
@ApplicationPath("/api/v1")
@ApplicationScoped
public class DemoApplication extends Application {

}