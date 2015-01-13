/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonDeserializer;

/**
 *
 * @author Muman
 */
public class CustomJsonDateDeserializer extends JsonDeserializer<Date>
{
    @Override
    public Date deserialize(JsonParser jsonparser,
            org.codehaus.jackson.map.DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {

        try {
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");//   'T'HH:mm:ss
            String date = jsonparser.getText();
            return format.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(CustomJsonDateDeserializer.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
    }

}