package practicalUnitTesting.chapter5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;

public class Chapter5Test {
    private Car myFerrari = mock(Car.class);

    @Test
    public void testIfCarIsACar() {
        assertTrue(myFerrari instanceof Car);
    }

    /*@Test
    public void testDefaultBehaviourOfTestDouble() {
        assertFalse("new test double should return false as boolean",
                myFerrari.needsFuel());
        assertEquals("new test double should return 0.0 as double",
                0.0, myFerrari.getEngineTemperature());
    }*/

    @Test
    public void testStubbing() {
        assertFalse("new test double should return false as boolean",
                myFerrari.needsFuel());
        when(myFerrari.needsFuel()).thenReturn(true);
        assertTrue("after instructed test double should return what we want",
                myFerrari.needsFuel());
    }

    @Test(expected = RuntimeException.class)
    public void throwException() {
        when(myFerrari.needsFuel())
                .thenThrow(new RuntimeException());
        myFerrari.needsFuel();
    }

    @Test
    public void testVerification() {
        myFerrari.driveTo("Sweet home Alabama");
        myFerrari.needsFuel();
        verify(myFerrari).driveTo("Sweet home Alabama");
        verify(myFerrari).needsFuel();
    }

   /* @Test
    public void testVerificationFailure() {
        myFerrari.needsFuel();
        verify(myFerrari).getEngineTemperature();
    }*/

    @Test
    public void sendMessage() {
        Client client = mock(Client.class);
        Template template = mock(Template.class);
        MailServer mailServer = mock(MailServer.class);
        TemplateEngine templateEngine = mock(TemplateEngine.class);
        String theMessage = "dear you're fired";
        String email = "pepito@gmail.com";

        when(client.getEmail()).thenReturn(email);
        when(templateEngine.prepareMessage(template, client)).thenReturn(theMessage);

        Messenger messenger = new Messenger(mailServer,templateEngine);
        messenger.sendMessage(client,template);

        verify(mailServer).send(email,theMessage);
    }

}
