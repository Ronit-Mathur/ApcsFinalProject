import javax.swing.JFrame;
public class ADRFrame extends JFrame
{
    private ADRComponent scene;
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;
    public ADRFrame() {
        scene = new ADRComponent();
        add(scene);
        setSize( FRAME_WIDTH, FRAME_HEIGHT);
    }
}
