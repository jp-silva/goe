package goe;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@ComponentScan({ "goe.*" })
@EnableAutoConfiguration
@Controller
@EnableRedisHttpSession
@EnableZuulProxy
@Import({ SecurityConfiguration.class})
public class GatewayApplication {

	@RequestMapping("/user")
	@ResponseBody
	public Map<String, Object> user(Principal user) {
		return Collections.<String, Object> singletonMap("name", user.getName());
	}

	@RequestMapping("/login")
	public String login() {
		return "forward:/";
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
