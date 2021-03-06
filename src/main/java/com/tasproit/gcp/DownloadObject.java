package com.tasproit.gcp;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DownloadObject {
	
	public static void main(String ar[]){
//		Path destFilePath = Paths.get("D:/TEMP/sample.txt");
//		downloadObject("psg-sg", "psg-sg", "ntuc_attach/sample.txt", destFilePath);
		
		Path pdfFilePath = Paths.get("D:/TEMP/NEWFOLDER/ABCD.pdf");
		downloadObject("psg-sg", "psg-sg", "ntuc_attach/NEWFOLDER/ABCD.pdf", pdfFilePath);
		
//		gs://psg-sg/ntuc_attach/NEWFOLDER/ABCD.pdf
	}
	
  public static void downloadObject(
		  
		  
      String projectId, String bucketName, String objectName, Path destFilePath) {
    // The ID of your GCP project
    // String projectId = "your-project-id";

    // The ID of your GCS bucket
    // String bucketName = "your-unique-bucket-name";

    // The ID of your GCS object
    // String objectName = "your-object-name";

    // The path to which the file should be downloaded
    // Path destFilePath = Paths.get("/local/path/to/file.txt");

    Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();

    Blob blob = storage.get(BlobId.of(bucketName, objectName));
    blob.downloadTo(destFilePath);

    System.out.println(
        "Downloaded object "
            + objectName
            + " from bucket name "
            + bucketName
            + " to "
            + destFilePath);
  }
}