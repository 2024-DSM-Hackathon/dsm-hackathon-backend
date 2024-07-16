package org.dsmhackatonbackend.domain.company.domain.repository

import org.dsmhackatonbackend.domain.company.domain.Company
import org.springframework.data.repository.CrudRepository

interface CompanyRepository : CrudRepository<Company, Long> {
}
