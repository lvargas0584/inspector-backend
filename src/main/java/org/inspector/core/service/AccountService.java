package org.inspector.core.service;

import org.inspector.core.dto.LoginDto;
import org.inspector.core.dto.SessionDto;

public interface AccountService {
    SessionDto login(LoginDto loginDto);
}
