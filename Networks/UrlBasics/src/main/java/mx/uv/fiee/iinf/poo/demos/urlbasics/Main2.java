package mx.uv.fiee.iinf.poo.demos.urlbasics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main2
{
    static String uri = "https://lipsum.app/id/24/1600x900";

    public static void main (String [] args) throws MalformedURLException, URISyntaxException {
        JFrame frame = new JFrame ();
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        BoxLayout layout = new BoxLayout (frame.getContentPane (), BoxLayout.Y_AXIS);
        frame.setLayout(layout);

        JPanel panel = new JPanel ();
        panel.setBackground (Color.lightGray);
        panel.setPreferredSize(new Dimension(400, 300));

        JButton btnSync = new JButton ("Download Image Sync");
        btnSync.addActionListener (v -> {
            try {
                Graphics2D graphics = (Graphics2D) panel.getGraphics ();
                BufferedImage image = ImageIO.read (new URL (uri));
                graphics.drawImage (image, 0, 0, panel.getWidth (), panel.getHeight (), null);
                graphics.dispose ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
        });

        JButton btnReset = new JButton ("Reset Canvas");
        btnReset.addActionListener (v -> panel.repaint ());

        HttpClient client = HttpClient
                .newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build ();

        HttpRequest request = HttpRequest.newBuilder (
                new URL (uri).toURI ()
        ).GET().build ();

        JButton btnAsync = new JButton ("Download Image Async");
        btnAsync.addActionListener(v -> {
            client.sendAsync (request, HttpResponse.BodyHandlers.ofByteArray ())
                    .thenApply (HttpResponse::body)
                    .thenAccept (data -> {
                        try {
                            DrawImage ((Graphics2D) panel.getGraphics (), 0, 0, panel.getWidth (), panel.getHeight(), data);
                        } catch (IOException e) {
                            e.printStackTrace();
                        };
                    });
        });

        JButton btnSend = new JButton ("Send Image to Server");
        btnSend.addActionListener (v -> {
            try {
                HttpRequest postRequest = HttpRequest.newBuilder(new URL(uri).toURI ())
                        .POST (HttpRequest.BodyPublishers.noBody())
                        .build ();

                client.sendAsync(postRequest, HttpResponse.BodyHandlers.ofString ())
                        .thenAccept (response -> {
                            System.out.println (response);
                        });
            } catch (URISyntaxException | MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        frame.add( panel );
        frame.add( btnSync );
        frame.add( btnReset );
        frame.add( btnAsync );
        frame.add( btnSend );
        frame.setVisible (true);
    }

    private static void DrawImage (Graphics2D graphics, int start, int end, int width, int height, byte[] data) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream (data);
        BufferedImage image = ImageIO.read (bais);
        graphics.drawImage (image, start, end, width, height, null);
        graphics.dispose ();
    }
}
