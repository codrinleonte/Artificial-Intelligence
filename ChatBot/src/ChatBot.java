import bitoflife.chatterbean.AliceBot;
import bitoflife.chatterbean.AliceBotMother;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

import java.util.*;

public class ChatBot {


    public boolean userExist(String name ){
        if(name!="no name"){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        try {

                AliceBotMother mother = new AliceBotMother();
                AliceBot mybot = mother.newInstance();
                ChatBot chatBot = new ChatBot();
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String newQuestion = br.readLine();

                ChatBotDao chatBotDao = new ChatBotDao();

                while (newQuestion !="exit") {
                    String str = mybot.respond(newQuestion);
                    System.out.println("ChatBot Mirel : " + str);


                    if(chatBotDao.getUsersbyName(mybot.getContext().property("predicate.name").toString())!=null){
                    }

                    else{
                       chatBotDao.addUser(mybot.getContext().property("predicate.name").toString());
                    }

                    if(!mybot.getContext().property("predicate.age").toString().equals("0")){
                        chatBotDao.updateUserAge(
                                mybot.getContext().property("predicate.name").toString(),
                                Integer.parseInt(mybot.getContext().property("predicate.age").toString()));

                    }

                    if(!mybot.getContext().property("predicate.occupation").toString().equals("somer")){
                        chatBotDao.updateUserOccupation(
                                mybot.getContext().property("predicate.name").toString(),
                                mybot.getContext().property("predicate.occupation").toString());
                    }

                   // System.out.println(mybot.getContext().property("predicate.age"));
                    newQuestion = br.readLine();


                }


                } catch(Exception ex){
                    System.err.println(ex.toString());
                }
        }
    }

