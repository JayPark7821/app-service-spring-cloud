package kr.perfume.perfumemodule.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.perfume.perfumemodule.entity.fragrance.Fragrance;
import kr.perfume.perfumemodule.searchcondition.FragranceSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static kr.perfume.perfumemodule.entity.fragrance.QFragrance.fragrance;
import static org.springframework.util.StringUtils.hasText;

@Repository
public class FragranceQueryRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public FragranceQueryRepository(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }


    public Page<Fragrance> searchFragrancesWithCondition(FragranceSearchCondition condition, Pageable pageable) {

        List<Fragrance> results = queryFactory
                .selectFrom(fragrance)
                .where(fragranceNameContains(condition.getFragranceName()),
                        fragranceDescContains(condition.getFragranceDesc())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(fragrance.id.desc())
                .fetch();

        JPAQuery<Fragrance> countQuery = queryFactory
                .selectFrom(fragrance)
                .where(fragranceNameContains(condition.getFragranceName()),
                        fragranceDescContains(condition.getFragranceDesc())
                );

        return PageableExecutionUtils.getPage(results, pageable, () -> countQuery.fetch().size());
    }

    private BooleanExpression fragranceDescContains(String desc) {
        return hasText(desc) ? fragrance.description.containsIgnoreCase(desc) : null;
    }

    private BooleanExpression fragranceNameContains(String name) {
        return hasText(name) ? fragrance.name.containsIgnoreCase(name) : null;
    }

}
