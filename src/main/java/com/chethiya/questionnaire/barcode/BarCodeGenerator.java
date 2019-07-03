package com.chethiya.questionnaire.barcode;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Date;

import com.chethiya.questionnaire.model.Participant;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.CodaBarWriter;

public class BarCodeGenerator {
	private static final String QR_CODE_IMAGE_PATH = "./MyQRCode.png";

	private static void generateBarCodeImage(Participant participant, int width, int height, String filePath)
			throws WriterException, IOException {
		CodaBarWriter codaBarWriter = new CodaBarWriter();

		System.out.println(participant.getBarCodeHash());
		BitMatrix bitMatrix = codaBarWriter.encode(participant.getBarCodeHash().toString(), BarcodeFormat.CODABAR,
				width, height);

		Path path = FileSystems.getDefault().getPath(filePath);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
	}

	public static void main(String[] args) {
		try {
			Participant participant = new Participant();
			participant.setFirstName("Chethiya");
			participant.setLastName("Palliyaguruge");
			participant.setDateOfBirth(new Date());
			participant.generateBarCodeHash();
			participant.setParticipantNIC("893593888v");
			generateBarCodeImage(participant, 350, 50, QR_CODE_IMAGE_PATH);
		} catch (WriterException e) {
			System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
		}
	}
}
