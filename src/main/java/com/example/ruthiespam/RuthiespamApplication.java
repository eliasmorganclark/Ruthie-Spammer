import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.math.BigDecimal;

public class Example {
    // Find your Account Sid and Token at twilio.com/console 
    public static final String ACCOUNT_SID = "ACbb788b5b1d2a80a0e2374cd47931a5e0";
    public static final String AUTH_TOKEN = "[AuthToken]";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("+13304729951"),
                        "Your message")
                .create();

        System.out.println(message.getSid());
    }
}