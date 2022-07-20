package GoldenDay.Komisyonsuz.Service;



import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import GoldenDay.Komisyonsuz.core.results.DataResult;


public interface ImageService {

    DataResult<Map> uploadImageFile(MultipartFile imageFile);
}