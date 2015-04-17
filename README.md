# MyFirstMaterial
A basic setup for navigation drawer on material design.

Took help from androidhive tutorial: http://www.androidhive.info/2015/04/android-getting-started-with-material-design/
Check styles.xml file for understanding styles.


Dynamic color

Material Design encourages dynamic use of color, especially when you have rich images to work with. The new Palette support library lets you extract a small set of colors from an image to style your UI controls to match; creating an immersive experience. The extracted palette will include vibrant and muted tones as well as foreground text colors for optimal legibility. For example:

Palette.generateAsync(bitmap,
        new Palette.PaletteAsyncListener() {
    @Override
    public void onGenerated(Palette palette) {
         Palette.Swatch vibrant =
                 palette.getVibrantSwatch();
          if (swatch != null) {
              // If we have a vibrant color
              // update the title TextView
              titleView.setBackgroundColor(
                  vibrant.getRgb());
              titleView.setTextColor(
                  vibrant.getTitleTextColor());
          }
    }
});