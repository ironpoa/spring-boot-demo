package br.com.southsystem.workshop.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CpfService {
    private final Map<String, String> cpfs = new HashMap<>();

    public CpfService() {
        cpfs.put("inacio", "394.329.532-13");
        cpfs.put("crystian", "421.568.542-13");
        cpfs.put("marlon", "935.246.765-15");
        cpfs.put("rafael", "335.633.097-09");
    }

    public Optional<Map<String, String>> findByName(String name) {
        if (cpfs.containsKey(name)) {
            final Map<String, String> result = new HashMap<>();
            result.put("name", name);
            result.put("cpf", cpfs.get(name));
            return Optional.of(result);
        }

        return Optional.empty();
    }
}
