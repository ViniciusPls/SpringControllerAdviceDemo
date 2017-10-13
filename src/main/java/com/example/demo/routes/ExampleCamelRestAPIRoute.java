package com.example.demo.routes;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.beans.ExampleBean;
import com.example.service.ExampleServices;

/**
 * A demonstration of how camel routes works to call a rest api. To call this
 * example use http://localhost:8080/camel/api/bean as URL with some json data
 * for {@link ExampleBean}.
 * 
 * e.g: { "id": 1, "name": "World" }
 * 
 * @author Carlos Pancioni
 *
 */
@Component
public class ExampleCamelRestAPIRoute extends RouteBuilder {

	@Value("${server.port}")
	String serverPort;

	@Value("${payX.api.path}")
	String contextPath;

	@SuppressWarnings("unused")
	@Override
	public void configure() throws Exception {
		CamelContext context = new DefaultCamelContext();

		restConfiguration().contextPath(contextPath).port(serverPort).enableCORS(true).apiContextPath("/api-doc")
				.apiProperty("api.title", "Test REST API").apiProperty("api.version", "v1").apiContextRouteId("doc-api")
				.component("servlet").bindingMode(RestBindingMode.json);

		rest("/api/").id("api-route").consumes("application/json").post("/bean").bindingMode(RestBindingMode.json_xml)
				.type(ExampleBean.class).to("direct:remoteService");

		from("direct:remoteService").routeId("direct-route").tracing().log(">>> ${body.id}").log(">>> ${body.name}")
				// .transform().simple("blue ${in.body.name}")
				.process(new Processor() {
					@Override
					public void process(Exchange exchange) throws Exception {
						final ExampleBean body = (ExampleBean) exchange.getIn().getBody();
						ExampleServices.exampleRestAPI(body);
						exchange.getIn().setBody(body);
					}
				}).setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201));
	}

}
