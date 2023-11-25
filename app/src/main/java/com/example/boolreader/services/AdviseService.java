package com.example.boolreader.services;

import com.example.boolreader.domain.Advise;
import com.example.boolreader.domain.Company;
import com.example.boolreader.domain.User;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class AdviseService {
    private static AdviseService instance;
    public static AdviseService getInstance() {
        return Objects.isNull(instance) ? instance = new AdviseService() : instance;
    }
    private CompanyService companyService = CompanyService.getInstance();
    private HashMap<UUID, Advise> advises = new HashMap<>();
    private Optional<Advise> selectedAdvise = Optional.empty();
    private AdviseService() {
    }

    public List<Advise> getAllAdvises() {
        return new ArrayList<>(advises.values());
    }

    public void createNewAdvise(String title, String text, UUID companyId) {
        Company company = companyService.getCompany(companyId);
        Advise newAdvise = new Advise(title, text, company);
        company.getAdvises().add(newAdvise);
        advises.put(newAdvise.getId(), newAdvise);
    }

    public void selectAdvise(UUID adviseId) {
        if (!advises.containsKey(adviseId)) {
            throw new InvalidParameterException("Совета с id " + adviseId + " не существует");
        }
        selectedAdvise = Optional.ofNullable(advises.get(adviseId));
    }

    public Advise getSelectedAdvise() {
        return selectedAdvise.orElseThrow(() -> new InvalidParameterException("Совет не выбрана"));
    }

}
