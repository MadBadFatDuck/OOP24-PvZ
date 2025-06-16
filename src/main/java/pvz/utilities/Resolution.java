package pvz.utilities;

/**
 * Enum representing different screen resolutions available in the game.
 */
public enum Resolution {

    /** 640×480 (VGA) resolution. */
    R640x480(640, 480, "640×480 (VGA)"),
    /** 800×600 (SVGA) resolution. */
    R800x600(800, 600, "800×600 (SVGA)"),
    /** 1024×768 (XGA) resolution. */
    R1024x768(1024, 768, "1024×768 (XGA)"),
    /** 1152×864 (SXGA-) resolution. */
    R1152x864(1152, 864, "1152×864 (SXGA-)"),
    /** 1600×1200 (UXGA) resolution. */
    R1600x1200(1600, 1200, "1600×1200 (UXGA)"),
    /** 2048×1536 (QXGA) resolution. */
    R2048x1536(2048, 1536, "2048×1536 (QXGA)"),
    /** 3840×2160 (4K UHD) resolution. */
    R3840x2160(3840, 2160, "3840×2160 (4K UHD)");

    /** The width of the resolution, in pixels. */
    private final int width;
    /** The height of the resolution, in pixels. */
    private final int height;
    /** Human-readable label for the resolution. */
    private final String label;

    /**
     * Constructs a Resolution enum with given dimensions and label.
     *
     * @param width  the width in pixels
     * @param height the height in pixels
     * @param label  the human-readable label for the resolution
     */
    Resolution(final int width, final int height, final String label) {
        this.width = width;
        this.height = height;
        this.label = label;
    }

    /**
     * Gets the width of the resolution.
     *
     * @return the width of the resolution
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the height of the resolution.
     *
     * @return the height of the resolution
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets the string representation of the resolution label.
     *
     * @return the string representation of the resolution label
     */
    @Override
    public String toString() {
        return label;
    }
}
