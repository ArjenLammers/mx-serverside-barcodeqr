# Description
This module leverages https://github.com/zxing/zxing to generate barcodes based on a string.
It includes a test interface to preview outcomes.
 
# Typical usage scenario
To generate a barcode or QR code based on a string and dimensions.

# Features and limitations
Generate a barcode.
Generate a QR code.

# Limitations
It is based on the ZXing library, which has a limited set of encoders available for barcodes.

# Dependencies
None.

# Installation
Add the module to your project.
If you want to experiment with outcomes, attach the Tests snippet to your flow.

# Configuration
The module consist of 1 action which requires a System.Image (create your own specialization), a string input and dimensions. The barcode will be generated in the supplied System.Image.
