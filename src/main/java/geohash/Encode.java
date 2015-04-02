package geohash;

import com.github.davidmoten.geo.GeoHash;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;

import java.io.IOException;

/**
 *
 * Computes the geohash of the provide lat/long pair to the requested precision (precision max of 12 chars).
 *
 */
public class Encode extends EvalFunc<String> {

    @Override
    public String exec(Tuple tuple) throws IOException {
        if (tuple == null || tuple.size() != 3){
            return null;
        }

        Double latitude = new Double(tuple.get(0).toString());
        Double longitude = new Double(tuple.get(1).toString());
        Integer precision = (Integer) tuple.get(2);

        String hash = GeoHash.encodeHash(latitude, longitude, precision);

        return hash;
    }

}
