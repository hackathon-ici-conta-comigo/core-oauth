package org.contacomigo.core.oauth.cucumber.stepdefs;

import org.contacomigo.core.oauth.OauthApp;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = OauthApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
