const Page = require('./page')

class LoginPage extends Page{

    get username(){
        return $('#user-name');
    }

    get password(){
        return $('#password');
    }

    get loginBtn(){
        return $('#login-button');
    }

    get errorMsg(){
        return $('h3[data-test="error"]');
    }

    async visitLoginPage() {
        await browser.url(`https://www.saucedemo.com`)
    }

    async confirmLoginPageDisplayed(){
        await expect(this.username).toBeExisting();
        await expect(this.password).toBeExisting();
        await expect(this.loginBtn).toBeExisting();
    }

    async authenticateUser(user, pass){
        if (user === undefined){
            user = 'standard_user';
        }
        if (pass === undefined){
            pass = 'secret_sauce';
        }

        await this.username.click();
        await this.username.setValue(user);
        await this.password.click();
        await this.password.setValue(pass);
        await this.loginBtn.click();
    }

    async validateInvalidLoginMsg(msg){
        expect(this.errorMsg).toHaveText(msg)
    }

}

module.exports = new LoginPage();