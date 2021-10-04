package com.sumerge;

import org.apache.commons.codec.binary.Base64;

import javax.validation.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

public class App 
{
    public static void main( String[] args )
    {
        // Task 1
        String value = "HelloWorld";
        byte[] bytesEncoded = Base64.encodeBase64(value.getBytes());
        String result = new String(bytesEncoded);

        System.out.println("Encoded Message: " + result);

        // Task 2
        AppValidation appValidation = new AppValidation();

        Patient valid_p = new Patient("mohamed adel", "adel@gmail.com", "17 ideal nasr city", 22);
        Patient notValid_p = new Patient("m", "a", "1", 0);

        // validate patients
        appValidation.validatePatient(valid_p);
        appValidation.validatePatient(notValid_p);
        System.out.println("-----------------------------");

        Appointment valid_app = new Appointment(valid_p, "mohamed adel",
                new GregorianCalendar(2022, Calendar.OCTOBER, 11).getTime());
        Appointment notValid_app = new Appointment(notValid_p, "m",
                new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime());

        // validate appointments
        appValidation.validateAppointment(valid_app);
        appValidation.validateAppointment(notValid_app);
    }
}

class AppValidation{
    ValidatorFactory factory;
    Validator validator;

    public AppValidation(){
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public void validatePatient(Patient patient){
        Set<ConstraintViolation<Patient>> violations = validator.validate(patient);

        for(ConstraintViolation<Patient> violation: violations){
            System.out.println(violation.getMessage());
        }
    }

    public void validateAppointment(Appointment appointment){
        Set<ConstraintViolation<Appointment>> violations = validator.validate(appointment);

        for(ConstraintViolation<Appointment> violation: violations){
            System.out.println(violation.getMessage());
        }
    }
}
