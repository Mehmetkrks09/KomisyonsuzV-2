package GoldenDay.Komisyonsuz.Service;

import java.io.IOException; 
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import GoldenDay.Komisyonsuz.core.results.DataResult;
import GoldenDay.Komisyonsuz.core.results.ErrorDataResult;
import GoldenDay.Komisyonsuz.core.results.SuccessDataResult;

@Service
public class ImageManager implements ImageService {

	private Cloudinary cloudinary;

	public ImageManager() {

		this.cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "mykodlama-io", "api_key", "442578988248129",
				"api_secret", "fTmUSo7DOVTE_b2Riw1QpqtjAWk"));

	}

	@Override
	public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap = (Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(),
					ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(resultMap);
		} catch (IOException e) {

			e.printStackTrace();

		}
		return new ErrorDataResult<Map>();
	}

}
