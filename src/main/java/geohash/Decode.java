package geohash;

import com.github.davidmoten.geo.GeoHash;
import com.github.davidmoten.geo.LatLong;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;

import java.io.IOException;

/**
 *
 * Decodes the provided geohash and returns the lat/long pair.
 *
 */
public class Decode extends EvalFunc<String> {

    @Override
    public String exec(Tuple tuple) throws IOException {
        if (tuple == null || tuple.size() != 1){
            return null;
        }
        String hash = tuple.get(0).toString();

        LatLong location = GeoHash.decodeHash(hash);

        return new String(location.getLat() + "," + location.getLon());
    }

}
