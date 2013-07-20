package maze;


/**
 * Holds String encodings of some previously designed mazes.
 * @author Zach Cotter
 */
public class Resources {

    public static final String A = "10\n"
                                   + "10\n"
                                   + "e,p,p,w,p,p,p,p,p,p,\n"
                                   + "w,w,p,w,p,w,w,w,w,s,\n"
                                   + "w,p,p,w,p,p,p,p,w,w,\n"
                                   + "p,p,w,w,w,w,w,p,w,p,\n"
                                   + "w,p,w,p,p,p,w,p,w,p,\n"
                                   + "w,p,w,p,w,p,p,p,w,p,\n"
                                   + "p,p,w,p,w,w,w,w,w,p,\n"
                                   + "w,p,w,p,p,p,p,p,p,p,\n"
                                   + "p,p,w,w,w,w,w,w,w,p,\n"
                                   + "w,p,p,p,p,p,p,p,p,p,\n";
    public static final String B = "10\n"
                                   + "10\n"
                                   + "w,w,w,p,w,w,w,p,w,w,\n"
                                   + "w,p,p,p,p,p,p,p,p,w,\n"
                                   + "w,p,w,p,w,w,w,w,p,w,\n"
                                   + "s,p,w,p,p,p,p,w,p,w,\n"
                                   + "w,p,w,p,w,w,p,w,p,w,\n"
                                   + "w,p,w,p,w,w,p,p,p,e,\n"
                                   + "w,p,w,p,p,p,p,w,p,w,\n"
                                   + "w,p,w,p,w,w,w,w,p,w,\n"
                                   + "w,p,p,p,p,p,p,p,p,w,\n"
                                   + "w,w,w,p,w,w,w,w,p,w,\n";
    public static final String C = "10\n"
                                   + "10\n"
                                   + "s,w,w,w,p,p,p,w,p,p,\n"
                                   + "p,p,p,p,p,w,p,w,p,w,\n"
                                   + "w,w,p,w,w,w,p,w,p,w,\n"
                                   + "p,p,p,w,p,p,p,p,p,p,\n"
                                   + "p,w,w,w,p,w,w,w,p,w,\n"
                                   + "p,p,p,w,p,w,p,w,p,e,\n"
                                   + "w,w,p,w,p,w,p,w,p,w,\n"
                                   + "p,p,p,w,p,w,p,w,p,p,\n"
                                   + "p,w,w,w,p,w,p,w,p,w,\n"
                                   + "p,p,p,w,p,p,p,w,p,p,\n";
    public static final String D =
                               "15\n15\nw,w,w,w,w,w,w,w,w,w,w,w,w,w,w,\nw,p,p,p,p,p,p,p,p,p,p,p,p,p,w,\nw,p,w,w,w,w,w,w,w,w,w,w,w,p,w,\nw,p,w,p,p,p,p,p,p,p,p,p,w,p,w,\nw,p,w,p,w,w,w,w,w,w,w,p,w,p,w,\nw,p,w,p,w,p,p,p,p,p,w,p,w,p,w,\nw,p,w,p,w,p,w,w,w,p,w,p,w,p,w,\nw,s,w,p,w,p,w,p,w,p,w,p,w,p,w,\nw,w,w,p,w,p,w,p,w,p,w,p,w,p,w,\nw,e,w,p,w,p,w,p,p,p,w,p,w,p,w,\nw,p,p,p,w,p,w,w,w,w,w,p,w,p,w,\nw,w,w,w,w,p,p,p,p,p,p,p,w,p,w,\nw,p,w,p,w,p,w,w,w,w,w,w,w,p,w,\nw,p,p,p,p,p,p,p,p,p,p,p,p,p,w,\nw,w,w,w,w,w,w,w,w,w,w,w,w,w,w,\n";
    public static final String E =
                               "20\n20\nw,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,\nw,s,p,p,p,p,p,w,w,p,p,p,p,p,p,p,p,p,p,w,\nw,w,p,w,w,w,p,w,p,p,w,w,w,w,w,w,w,w,p,w,\nw,p,p,w,p,w,p,w,p,w,w,p,p,p,p,p,p,p,p,w,\nw,p,w,w,p,w,p,w,p,w,p,p,w,w,w,w,w,w,p,w,\nw,p,w,w,p,w,p,w,p,w,p,w,w,p,p,p,p,w,p,w,\nw,p,w,p,p,w,p,w,p,w,p,w,p,p,w,w,w,w,p,w,\nw,p,w,p,w,w,p,w,p,w,p,w,p,w,w,p,p,p,p,w,\nw,p,w,p,p,w,p,w,p,w,p,w,p,w,p,p,w,w,p,w,\nw,p,w,w,p,w,p,w,p,w,p,w,p,w,p,w,w,w,p,w,\nw,p,w,p,p,w,p,w,p,w,p,w,p,w,p,w,p,p,p,w,\nw,p,w,p,w,w,p,w,p,w,p,w,p,w,p,w,w,w,p,w,\nw,p,w,p,p,w,p,w,p,w,p,w,p,w,p,p,p,w,p,w,\nw,p,w,w,p,w,p,w,p,w,p,w,p,w,w,w,w,w,p,w,\nw,p,w,p,p,w,p,w,p,w,p,w,p,p,p,p,p,p,p,w,\nw,p,w,p,w,w,p,w,p,w,p,w,w,w,w,w,w,w,p,w,\nw,p,w,p,p,p,p,w,e,w,p,p,p,p,p,p,p,w,p,w,\nw,p,w,w,w,w,p,w,w,w,w,w,w,w,w,w,w,w,p,w,\nw,p,p,p,p,p,p,p,p,p,p,p,p,p,p,p,p,p,p,w,\nw,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,\n";
    public static final String F =
                               "25\n25\nw,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,\nw,s,w,p,p,p,p,p,p,p,p,p,p,p,p,p,p,p,p,p,p,p,p,p,w,\nw,p,w,w,w,w,w,w,p,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,\nw,p,w,p,w,p,p,p,p,p,p,p,p,p,p,p,p,p,p,p,p,p,w,p,w,\nw,p,w,p,w,w,w,w,w,w,w,w,w,p,w,w,w,w,w,w,w,w,w,p,w,\nw,p,p,p,w,p,p,p,p,p,p,p,p,p,p,p,p,p,w,p,w,p,w,p,w,\nw,p,w,p,w,w,w,w,w,w,p,w,w,w,w,w,w,w,w,p,w,p,p,p,w,\nw,p,w,p,p,p,w,p,w,p,p,p,p,p,p,p,p,p,w,p,w,p,w,p,w,\nw,p,w,p,w,p,w,p,w,w,w,w,p,w,w,w,w,w,w,p,w,p,w,p,w,\nw,p,w,p,w,p,w,p,w,p,p,p,p,p,p,p,w,p,w,p,w,p,w,p,w,\nw,p,w,p,w,p,w,p,w,p,w,w,w,w,w,p,w,p,w,p,w,p,w,p,w,\nw,p,w,p,w,p,w,p,w,p,w,e,p,p,w,p,w,p,w,p,p,p,w,p,w,\nw,p,w,p,w,p,p,p,p,p,w,w,w,p,w,p,p,p,w,p,w,p,w,p,w,\nw,p,w,p,w,p,w,p,w,p,p,p,p,p,w,p,w,p,w,p,w,p,w,p,w,\nw,p,w,p,w,p,w,p,w,p,w,w,w,w,w,p,w,p,w,p,w,p,w,p,w,\nw,p,w,p,w,p,w,p,w,p,p,p,p,p,p,p,w,p,p,p,w,p,w,p,w,\nw,p,w,p,w,p,w,w,w,w,w,w,p,w,w,w,w,p,w,p,w,p,w,p,w,\nw,p,w,p,w,p,w,p,p,p,p,p,p,p,p,p,w,p,w,p,w,p,w,p,w,\nw,p,w,p,w,p,w,w,w,p,w,w,w,w,w,w,w,w,w,w,w,p,w,p,w,\nw,p,w,p,w,p,w,p,p,p,p,p,p,p,p,p,p,p,p,p,w,p,w,p,w,\nw,p,w,w,w,w,w,w,w,w,w,p,w,w,w,w,w,w,w,w,w,p,w,p,w,\nw,p,w,p,p,p,p,p,p,p,p,p,p,p,p,p,p,p,p,p,w,p,w,p,w,\nw,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,p,w,w,w,w,w,p,w,\nw,p,p,p,p,p,p,p,p,p,p,p,p,p,p,p,p,p,p,p,p,p,w,p,w,\nw,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,w,\n";
}
