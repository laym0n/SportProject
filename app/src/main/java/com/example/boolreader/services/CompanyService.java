package com.example.boolreader.services;

import com.example.boolreader.domain.Company;
import com.example.boolreader.domain.User;

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
    private Optional<User> currentUser;
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
        Company company = companies.get(companyId);
        User curUser = authService.getCurrentUser();
        curUser.getSubscribes().add(company);
    }

}