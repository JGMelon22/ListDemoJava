package com.melon.config;

import org.jooq.codegen.GenerationTool;
import org.jooq.meta.jaxb.*;
import org.jooq.meta.jaxb.Configuration;

public class JOOQConfig {
	public static void main(String[] args) throws Exception {
		Configuration configuration = new Configuration()
				.withJdbc(new Jdbc().withDriver("com.mysql.cj.jdbc.Driver")
						.withUrl("jdbc:mysql://172.17.0.2:3306/jooq_demo").withUser("root").withPassword("Melon@123"))
				.withGenerator(new Generator()
						.withDatabase(new Database().withName("org.jooq.meta.mysql.MySQLDatabase").withIncludes(".*")
								.withExcludes("").withInputSchema("jooq_demo"))
						.withTarget(new Target().withPackageName("com.melon.mysql.generatedclasses")
								.withDirectory("src/main/java")));

		GenerationTool.generate(configuration);

	}
}
