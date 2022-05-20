package com.example.ruthie;

import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.TwiML;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Media;
import com.twilio.twiml.messaging.Message;

 import static spark.Spark.*;

public class SmsApp {
    public static void main(String[] args) {
        get("/", (req, res) -> "Hello Web");

        post("/sms", (req, res) -> {
            res.type("application/xml");
            String howdy = randomNote();
            Body body = new Body
                    .Builder(howdy)
                    .build();
            String url = randomRuthie();
            Media media = new Media.Builder(url).build();
            Message sms = new Message
                    .Builder()
                    .body(body)
                    .media(media)
                    .build();
            MessagingResponse twiml = new MessagingResponse
                    .Builder()
                    .message(sms)
                    .build();
            return twiml.toXml();
        });
    }
    static String randomNote(){
        int r = (int) (Math.random()*5);
        String ruthieNote = new String [] {
                "Hey Nerd! Here's RUTHIE! -Elias",
                "Howdy, here's my cat. Enjoy! -Elias",
                "Behold.................. amazing. -Elias",
                "Can you believe it? It's Ruthie. WOWZA!! -Elias",
                "This is where I would hypothetically paste the entirety of the Bee Movie script, but it's late and I'm tired. Here's my cat. -EC"

        }[r];
        return ruthieNote;
    }

    static String randomRuthie(){
        int r = (int) (Math.random()*5);
        String ruthieURL = new String [] {
                "http://mementocat.com/images/ruthies/01.jpg",
                "http://mementocat.com/images/ruthies/02.jpg",
                "http://mementocat.com/images/ruthies/03.jpg",
                "http://mementocat.com/images/ruthies/04.jpg",
                "http://mementocat.com/images/ruthies/05.jpg"

        }[r];
        return ruthieURL;
    }
}

   // twilio phone-numbers:update "+19183934179" --sms-url="http://localhost:4567/sms"