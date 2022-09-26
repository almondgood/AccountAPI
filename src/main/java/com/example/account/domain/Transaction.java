package com.example.account.domain;

import com.example.account.type.TransactionResultType;
import com.example.account.type.TransactionType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Transaction {
    /**
     * PK를 APi에 직접적으로 노출시킬 경우
     * 해킹이나 회사 중요 정보가 누설될 수 있음
     * => 내부적으로 APi 호출 시에만 사용
     */
    @Id // PK 지정
    @GeneratedValue
    private Long id;



    @Enumerated(EnumType.STRING) // 열거형을 문자형태로 저장
    private TransactionType transactionType;
    @Enumerated(EnumType.STRING) // 열거형을 문자형태로 저장
    private TransactionResultType transactionResult;

    @ManyToOne
    private Account account;
    private Long amount;
    private Long balanceSnapshot;

    /**
     * PK 대신 외부에서 키 값처럼 사용
     */
    private String transactionId;
    private LocalDateTime transactedAt;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
