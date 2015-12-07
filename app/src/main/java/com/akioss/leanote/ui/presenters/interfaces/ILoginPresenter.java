package com.akioss.leanote.ui.presenters.interfaces;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 15/12/2.
 * Package: com.akioss.leanote.ui.presenters.interfaces
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public interface ILoginPresenter {

    void login(String email, String pwd);

    void register(String email, String pwd);

    void findLostPwd();
}