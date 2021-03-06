package jsonUtil;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import model.parkModel.LocationInfoModel;
import model.parkModel.PaymentInfoModel;

import park.Park;

import util.*;

public class ParkValidator {
	public Park parkValidation(String parkJSON) throws Exception {
		Park park = jsonParser(parkJSON);
		return park;
	}

	// TODO: very ugly, need change, and need to save parks using containers
	private Park jsonParser(String parkJSON) throws Exception {

		Park park = new Park();
		PaymentInfoModel paymentInfoModel = new PaymentInfoModel();

		JsonParser jsonParser = new JsonParser();
		JsonElement jsonElement = jsonParser.parse(parkJSON);

		Type listType = new TypeToken<List<Integer>>() {
		}.getType();

		if (jsonElement.isJsonObject()) {

			JsonObject jsonObject = jsonElement.getAsJsonObject();
			JsonObject locationInfoJSON = jsonObject.getAsJsonObject("location_info");
			JsonObject geoJSON = locationInfoJSON.getAsJsonObject("geo");

			float[] geo = { geoJSON.get("lat").getAsFloat(), geoJSON.get("lng").getAsFloat() };

			park.setLocationInfoModel(new LocationInfoModel(locationInfoJSON.get("name").getAsString(),
					locationInfoJSON.get("region").getAsString(), locationInfoJSON.get("address").getAsString(),
					locationInfoJSON.get("phone").getAsString(), locationInfoJSON.get("web").getAsString(), geo));

			JsonObject paymentInfoJSON = jsonObject.getAsJsonObject("payment_info");

			JsonElement carPriceJSON = paymentInfoJSON.get("car");
			JsonElement rvPriceJSON = paymentInfoJSON.get("rv");
			JsonElement motorcyclePriceJSON = paymentInfoJSON.get("motorcycle");

			List<Integer> carPrices = new Gson().fromJson(carPriceJSON, listType);
			List<Integer> rvPrices = new Gson().fromJson(rvPriceJSON, listType);
			List<Integer> motorcyclePrices = new Gson().fromJson(motorcyclePriceJSON, listType);

			paymentInfoModel.addPrices("car", ArrayFormatter.toIntArray(carPrices));
			paymentInfoModel.addPrices("rv", ArrayFormatter.toIntArray(rvPrices));
			paymentInfoModel.addPrices("motorcycle", ArrayFormatter.toIntArray(motorcyclePrices));

			park.setPaymentInfoModel(paymentInfoModel);
		}
		return park;
	}
}