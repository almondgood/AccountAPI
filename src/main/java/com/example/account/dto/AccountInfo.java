package com.example.account.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
// 컨트롤러와 컨트롤러 간 dto
// dto는 다용도인 domain과 달리 특화된 용도로 사용한다.
public class AccountInfo {
    private String accountNumber;
    private Long balance;
}
