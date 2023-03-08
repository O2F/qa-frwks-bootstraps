//https://demoqa.com/automation-practice-form

class PracticeFormPage{

    get firstNameField(){
        return $('#firstName');
    }

    get lastNameField(){
        return $('#lastName');
    }

    get emailField(){
        return $('#userEmail');
    }

    get genderMale(){
        return $('[id*="gender-radio"][value="Male"]');
    }

    get mobileNumber(){
        return $('#userNumber');
    }

    get hobbiesCheckboxList(){
        return $$("[for*='hobbies-checkbox']");
    }

    async visitPracticeForm(){
        await browser.url('https://demoqa.com/automation-practice-form');
    }

    async fillFirstName(fname){
        if (fname === undefined){
            fname = 'John';
        }
        await this.firstNameField.setValue(fname);
    }

    async fillLastName(lname){
        if (lname === undefined){
            lname = 'Doe';
        }
        await this.lastNameField.setValue(lname);
    }

    async fillEmail(email){
        if(email === undefined){
            email = 'teste@teste.com'
        }

        await this.emailField.setValue(email);
    }

    async selectAllHobbies(){
        await this.hobbiesCheckboxList.forEach(async el => {
            await el.click()
        });
    }
}

module.exports = new PracticeFormPage();