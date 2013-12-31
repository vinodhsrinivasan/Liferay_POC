package oh.lccs.portal.portlet.validation;

/**
 * Helper Class that contains the constants used on form validation.
 * 
 * @author compuware developer
 * 
 */
public final class ValidationConstant {

    // Field names
    public static final String ADDRESS_MORE_ONE_YEAR_FIELD_NAME = "addressMoreOneYear";
    public static final String SAME_MAILING_ADDRESS_FIELD_NAME = "sameMailingAddress";
    public static final String RESIDENCE_STATUS_FIELD_NAME = "residenceStatus";

    // Validation values
    public static final String ADDRESS_MORE_ONE_YEAR_NO_VALUE = "No";
    public static final String RESIDENCE_STATUS_RENT_OTHER_VALUE = "rent_other";
    public static final String CHECKED_VALUE = "on";
    // validation max
    public static final int FIRSTNAME_MAXSIZE = 14;
    public static final int LASTNAME_MAXSIZE = 20;
    public static final int ADDRESS_STREET_MAXSIZE = 23;
    public static final int ADDRESS_CITY_MAXSIZE = 15;
    public static final int DRIVER_NUMBER_MAXSIZE = 20;
    public static final String ANNUAL_INCOME_MAX = "9999999999";
    public static final String MONTHLY_PAYMENT_MAX = "9999999999";

    // validation patterns
    public static final String ZIPCODE_PATTERN = "^\\d{5}|\\d{9}$";
    public static final String DAY_PATTERN = "(0?[1-9]|[12][0-9]|3[01])";
    public static final String MONTH_PATTERN = "(0?[1-9]|1[012])";
    public static final String YEAR_PATTERN = "((19|20)\\d\\d)";
    public static final String FIRST_PHONE_PATTERN = "^\\d{3}$";
    public static final String SECOND_PHONE_PATTERN = FIRST_PHONE_PATTERN;
    public static final String THIRD_PHONE_PATTERN = "^\\d{4}$";
    public static final String FIRST_SSN_PATTERN = "^\\d{3}$";
    public static final String SECOND_SSN_PATTERN = "^\\d{2}$";
    public static final String THIRD_SSN_PATTERN = "^\\d{4}$";

    public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{1,})$";

    // Validation messages
    public static final String REQUIRED_FIRSTNAME_MESSAGE = "form.firstname.required.error";
    public static final String INVALID_FIRSTNAME_MESSAGE = "form.firstname.invalid.error";
    public static final String REQUIRED_LASTNAME_MESSAGE = "form.lastname.required.error";
    public static final String INVALID_LASTNAME_MESSAGE = "form.lastname.invalid.error";
    public static final String REQUIRED_DATEOFBIRTH_MONTH_MESSAGE = "form.dateofbirth.month.required.error";
    public static final String INVALID_DATEOFBIRTH_MONTH_MESSAGE = "form.dateofbirth.month.invalid.error";
    public static final String REQUIRED_DATEOFBIRTH_DAY_MESSAGE = "form.dateofbirth.day.required.error";
    public static final String INVALID_DATEOFBIRTH_DAY_MESSAGE = "form.dateofbirth.day.invalid.error";
    public static final String REQUIRED_DATEOFBIRTH_YEAR_MESSAGE = "form.dateofbirth.year.required.error";
    public static final String INVALID_DATEOFBIRTH_YEAR_MESSAGE = "form.dateofbirth.year.invalid.error";
    public static final String REQUIRED_RESIDENTIAL_STREET_MESSAGE = "form.residential.street.required.error";
    public static final String INVALID_RESIDENTIAL_STREET_MESSAGE = "form.residential.street.invalid.error";
    public static final String REQUIRED_RESIDENTIAL_STATE_MESSAGE = "form.residential.state.required.error";
    public static final String REQUIRED_RESIDENTIAL_CITY_MESSAGE = "form.residential.city.required.error";
    public static final String INVALID_RESIDENTIAL_CITY_MESSAGE = "form.residential.city.invalid.error";
    public static final String REQUIRED_RESIDENTIAL_ZIPCODE_MESSAGE = "form.residential.zipcode.required.error";
    public static final String INVALID_RESIDENTIAL_ZIPCODE_MESSAGE = "form.residential.zipcode.invalid.error";
    public static final String REQUIRED_PREVIOUS_RESIDENTIAL_STREET_MESSAGE = "form.previous.street.required.error";
    public static final String INVALID_PREVIOUS_RESIDENTIAL_STREET_MESSAGE = "form.previous.street.invalid.error";
    public static final String REQUIRED_PREVIOUS_RESIDENTIAL_CITY_MESSAGE = "form.previous.city.required.error";
    public static final String INVALID_PREVIOUS_RESIDENTIAL_CITY_MESSAGE = "form.previous.city.invalid.error";
    public static final String REQUIRED_PREVIOUS_RESIDENTIAL_STATE_MESSAGE = "form.previous.state.required.error";
    public static final String REQUIRED_PREVIOUS_RESIDENTIAL_ZIPCODE_MESSAGE = "form.previous.zipcode.required.error";
    public static final String INVALID_PREVIOUS_RESIDENTIAL_ZIPCODE_MESSAGE = "form.previous.zipcode.invalid.error";
    public static final String REQUIRED_MAILING_ADDRESS_STREET_MESSAGE = "form.mailing.street.required.error";
    public static final String INVALID_MAILING_ADDRESS_STREET_MESSAGE = "form.mailing.street.invalid.error";
    public static final String REQUIRED_MAILING_ADDRESS_CITY_MESSAGE = "form.mailing.city.required.error";
    public static final String INVALID_MAILING_ADDRESS_CITY_MESSAGE = "form.mailing.city.invalid.error";
    public static final String REQUIRED_MAILING_ADDRESS_STATE_MESSAGE = "form.mailing.state.required.error";
    public static final String REQUIRED_MAILING_ADDRESS_ZIPCODE_MESSAGE = "form.mailing.zipcode.required.error";
    public static final String INVALID_MAILING_ZIPCODE_MESSAGE = "form.mailing.zipcode.invalid.error";
    public static final String REQUIRED_HOMEPHONE1_MESSAGE = "form.homephone1.required.error";
    public static final String INVALID_HOMEPHONE1_MESSAGE = "form.homephone1.invalid.error";
    public static final String REQUIRED_HOMEPHONE2_MESSAGE = "form.homephone2.required.error";
    public static final String INVALID_HOMEPHONE2_MESSAGE = "form.homephone2.invalid.error";
    public static final String REQUIRED_HOMEPHONE3_MESSAGE = "form.homephone3.required.error";
    public static final String INVALID_HOMEPHONE3_MESSAGE = "form.homephone3.invalid.error";
    public static final String REQUIRED_EMAIL_MESSAGE = "form.email.required.error";
    public static final String INVALID_WORKPHONE1_MESSAGE = "form.workphone1.invalid.error";
    public static final String INVALID_WORKPHONE2_MESSAGE = "form.workphone2.invalid.error";
    public static final String INVALID_WORKPHONE3_MESSAGE = "form.workphone3.invalid.error";
    public static final String INVALID_EMAIL_MESSAGE = "form.email.invalid.error";
    public static final String REQUIRED_CONFIRMEMAIL_MESSAGE = "form.confirmemail.required.error";
    public static final String INVALID_CONFIRMEMAIL_MESSAGE = "form.confirmemail.invalid.error";
    public static final String REQUIRED_SSN1_MESSAGE = "form.ssn1.required.error";
    public static final String INVALID_SSN1_MESSAGE = "form.ssn1.invalid.error";
    public static final String REQUIRED_SSN2_MESSAGE = "form.ssn2.required.error";
    public static final String INVALID_SSN2_MESSAGE = "form.ssn2.invalid.error";
    public static final String REQUIRED_SSN3_MESSAGE = "form.ssn3.required.error";
    public static final String INVALID_SSN3_MESSAGE = "form.ssn3.invalid.error";
    public static final String REQUIRED_DRIVERNUMBER_MESSAGE = "form.drivernumber.required.error";
    public static final String INVALID_DRIVERNUMBER_MESSAGE = "form.drivernumber.invalid.error";
    public static final String REQUIRED_ISSUINGSTATE_MESSAGE = "form.issuingstate.required.error";
    public static final String REQUIRED_ANNUALINCOME_MESSAGE = "form.annualincome.required.error";
    public static final String INVALID_ANNUALINCOME_MESSAGE = "form.annualincome.invalid.error";
    public static final String REQUIRED_RESIDENCESTATUS_MESSAGE = "form.residencestatus.required.error";
    public static final String REQUIRED_MONTHLYPAYEMENT_MESSAGE = "form.monthlypayment.required.error";
    public static final String INVALID_MONTHLYPAYEMENT_MESSAGE = "form.monthlyPayment.invalid.error";
    public static final String REQUIRED_TEREMSANDCONDITION_MESSAGE = "form.terms.select.error";
    public static final String REQUIRED_ELECTRONIC_COMMUNICATION_MESSAGE = "form.consent.select.error";

    // Validation messages for registration (those not written above)
    public static final String CCN_PATTERN = "^\\d{3}$";
    public static final String REQUIRED_PASSWORD_MESSAGE = "form.password.required.error";
    public static final String REQUIRED_CONFIRMPASSWORD_MESSAGE = "form.confirmPassword.required.error";
    public static final String INVALID_CONFIRMPASSWORD_MESSAGE = "form.confirmPassword.invalid.error";
    public static final String REQUIRED_CCN1_MESSAGE = "form.ccn1.required.error";
    public static final String INVALID_CCN1_MESSAGE = "form.ccn1.invalid.error";
    public static final String REQUIRED_CCN2_MESSAGE = "form.ccn2.required.error";
    public static final String INVALID_CCN2_MESSAGE = "form.ccn2.invalid.error";
    public static final String REQUIRED_CCN3_MESSAGE = "form.ccn3.required.error";
    public static final String INVALID_CCN3_MESSAGE = "form.ccn3.invalid.error";
    public static final String REQUIRED_USERNAME_MESSAGE = "form.userName.required.error";
    public static final String REQUIRED_QUESTION_MESSAGE = "form.question.required.error";
    public static final String REQUIRED_ANSWER_MESSAGE = "form.answer.required.error";
    public static final String REQUIRED_CONSENT_MESSAGE = "form.consent.select.error";

    private ValidationConstant() {
    }
}
