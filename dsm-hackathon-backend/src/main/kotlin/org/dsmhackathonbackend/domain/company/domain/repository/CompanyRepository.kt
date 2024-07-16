package org.dsmhackathonbackend.domain.company.domain.repository

import org.dsmhackathonbackend.domain.company.domain.Company
import org.springframework.data.repository.CrudRepository

interface CompanyRepository : CrudRepository<Company, Long> {
}
