package com.example.boolreader.services;

import com.example.boolreader.domain.Company;
import com.example.boolreader.domain.User;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class CompanyService {
    private static CompanyService instance;
    public static CompanyService getInstance() {
        return Objects.isNull(instance) ? instance = new CompanyService() : instance;
    }
    private AuthService authService = AuthService.getInstance();
    private HashMap<UUID, Company> companies = new HashMap<>();
    private Optional<Company> selectedCompany = Optional.empty();
    private CompanyService() {
    }

    public List<Company> getOwningCompaniesOfCurrentUser() {
        return authService.getCurrentUser().getOwningCompanies();
    }

    public List<Company> getSubscribedCompaniesOfCurrentUser() {
        return authService.getCurrentUser().getSubscribes();
    }

    public void createNewCompany(String name, String address) {
        User curUser = authService.getCurrentUser();
        Company newCompany = new Company(name, address, curUser);
        curUser.getOwningCompanies().add(newCompany);
        companies.put(newCompany.getId(), newCompany);
    }

    public void subscribeToCompany(UUID companyId) {
        if (isCurUserSubscribed(companyId)) {
            return;
        }
        User curUser = authService.getCurrentUser();
        List<Company> subscribes = curUser.getSubscribes();
        Company company = companies.get(companyId);
        subscribes.add(company);
    }

    public void unSubscribeToCompany(UUID companyId) {
        if (!isCurUserSubscribed(companyId)) {
            return;
        }
        User curUser = authService.getCurrentUser();
        List<Company> subscribes = curUser.getSubscribes();
        Company company = companies.get(companyId);
        subscribes.remove(company);
    }

    public void selectCompany(UUID companyId) {
        isExistCompany(companyId);
        selectedCompany = Optional.ofNullable(companies.get(companyId));
    }

    public Company getSelectedCompany() {
        return selectedCompany.orElseThrow(() -> new InvalidParameterException("Компания не выбрана"));
    }

    public boolean isCurUserSubscribed(UUID companyId) {
        User curUser = authService.getCurrentUser();
        List<Company> subscribes = curUser.getSubscribes();
        return subscribes.stream().anyMatch(company -> company.getId().equals(companyId));
    }

    public Company getCompany(UUID companyId) {
        isExistCompany(companyId);
        return companies.get(companyId);
    }

    private void isExistCompany(UUID companyId) {
        if (!companies.containsKey(companyId)) {
            throw new InvalidParameterException("Компании с id " + companyId + " не существует");
        }
    }
}
