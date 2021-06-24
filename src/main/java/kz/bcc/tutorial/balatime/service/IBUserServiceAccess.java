package kz.bcc.tutorial.balatime.service;

import kz.bcc.tutorial.balatime.model.BUser;

public interface IBUserServiceAccess {

    BUser findByLoginIgnoreCase(String login) throws Exception;

    BUser registrationUser(BUser user) throws Exception;

}
