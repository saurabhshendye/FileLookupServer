/*
 * Created by Saurabh on 04/06/2017.
 */

package Transport;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TCPSender
{
    private Socket socket;
    private DataOutputStream dout;

    public TCPSender(Socket S) throws IOException
    {
        this.socket = S;
        dout = new DataOutputStream(socket.getOutputStream());
    }

    public synchronized void send_and_maintain(byte[] data_to_send) throws IOException
    {
        int D_len = data_to_send.length;
        dout.writeInt(D_len);
        dout.write(data_to_send, 0, D_len);
        dout.flush();
    }
}
