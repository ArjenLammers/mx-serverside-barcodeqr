// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package barcode.actions;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Hashtable;
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class GenerateBarcode extends CustomJavaAction<java.lang.Void>
{
	private java.lang.String text;
	private barcode.proxies.BarcodeFormat format;
	private java.lang.Long width;
	private java.lang.Long height;
	private IMendixObject __destination;
	private system.proxies.Image destination;

	public GenerateBarcode(IContext context, java.lang.String text, java.lang.String format, java.lang.Long width, java.lang.Long height, IMendixObject destination)
	{
		super(context);
		this.text = text;
		this.format = format == null ? null : barcode.proxies.BarcodeFormat.valueOf(format);
		this.width = width;
		this.height = height;
		this.__destination = destination;
	}

	@java.lang.Override
	public java.lang.Void executeAction() throws Exception
	{
		this.destination = __destination == null ? null : system.proxies.Image.initialize(getContext(), __destination);

		// BEGIN USER CODE
		MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
		BarcodeFormat bcFormat = BarcodeFormat.valueOf(format.name());
		Hashtable hints = new Hashtable();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8"); // add hints to support utf-8
		BitMatrix matrix = multiFormatWriter.encode(text, bcFormat, width.intValue(), height.intValue(), hints); // add hints
		BitMatrix matrix = multiFormatWriter.encode(text, bcFormat, width.intValue(), height.intValue());
		BufferedImage bufImage = MatrixToImageWriter.toBufferedImage(matrix);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ImageIO.write(bufImage, "png", os);
			Core.storeFileDocumentContent(getContext(), __destination, 
					new ByteArrayInputStream(os.toByteArray()));
		} finally {
			os.close();
		}	
		return null;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "GenerateBarcode";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
