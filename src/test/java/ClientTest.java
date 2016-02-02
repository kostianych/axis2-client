import by.tut.kostianych.SayHi;
import by.tut.kostianych.SayHiDocument;
import by.tut.kostianych.SayHiResponseDocument;
import by.tut.kostianych.axis2.client.CustomFault;
import by.tut.kostianych.axis2.client.HelloWorldImplServiceStub;
import org.junit.Test;

import java.rmi.RemoteException;

import static org.junit.Assert.assertEquals;

/**
 * Created by chyzhykau_k on 02/01/2016.
 */
public class ClientTest {

    @Test
    public void testAxis2Client() throws RemoteException, CustomFault {
        HelloWorldImplServiceStub stub =
                new HelloWorldImplServiceStub
                        ("http://localhost:8080/cxf-jax-ws-service/HelloWorld");
        SayHiDocument sayHiDocument = SayHiDocument.Factory.newInstance();
        SayHi sayHi = SayHi.Factory.newInstance();
        sayHi.setArg0("Herr");
        sayHiDocument.setSayHi(sayHi);
        SayHiResponseDocument response = stub.sayHi(sayHiDocument);
        assertEquals("Hello Herr", response.getSayHiResponse().getReturn());
    }

}
