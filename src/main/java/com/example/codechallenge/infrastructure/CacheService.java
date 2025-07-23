package com.example.codechallenge.infrastructure;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheService {

    private static final long TTL_MILLIS = 5 * 60 * 1000; // 5 minutos
    private final Map<String, Entry> cache = new ConcurrentHashMap<>();

    public static class Entry {
        public final String responseJson;
        public final long timestamp;

        public Entry(String responseJson) {
            this.responseJson = responseJson;
            this.timestamp = Instant.now().toEpochMilli();
        }
    }

    public String get(String key) {
        Entry e = cache.get(key);
        if (e != null && (Instant.now().toEpochMilli() - e.timestamp) < TTL_MILLIS) {
            return e.responseJson;
        }
        return null;
    }

    public void put(String key, String responseJson) {
        cache.put(key, new Entry(responseJson));
    }

    public String generateKey(String marca, String modelo, int anio, String tipoUso, int edadConductor) {
        return String.format("%s-%s-%d-%s-%d", marca, modelo, anio, tipoUso, edadConductor);
    }
}
