package com.food.repository.spec;

import com.food.entity.Category;
import com.food.entity.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ProductSpec {

	public static Specification<Product> nameLike(String name) {

		return (root, query, criteriaBuilder) -> {
			if (! StringUtils.isEmpty(name)) {
				return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%");
			} else
				return null;

		};
	}
	public static Specification<Product> quantityLessThan2(int categoryId) {

		return (root, query, cb) -> {

			Subquery<Category> subquery = query.subquery(Category.class);
			Root<Category> categoryRoot = subquery.from(Category.class);
			Expression<Collection<Category>> products = categoryRoot.get("products");
			subquery.select(categoryRoot);
			subquery.where(cb.equal(categoryRoot.get("id"),categoryId));
			return cb.exists(subquery);
		};
	}

	public static Specification<Product> quantityLessThan(int quantity) {

		return (root, query, criteriaBuilder) -> {
				return criteriaBuilder.lessThan(root.get("quantity"),quantity);
		};
	}

	public static Specification<Product> hasOffer() {
		return	(new Specification<Product>() {
	


				@Override
				public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
					return criteriaBuilder.isNotNull(root.get("offer"));
				}
			});
	
	}

	public static Specification<Product> idEqual(Integer id) {

		return (root, query, criteriaBuilder) -> {
			if (id == null || id < 0)
				return null;
			else {
				return criteriaBuilder.equal(root.get("id"), id);
			}
		};
	}

	public static Specification<Product> quantityEqual(Integer quantity) {

		return (root, query, criteriaBuilder) -> {
			if (quantity == null || quantity < 0)
				return null;
			else {
				return criteriaBuilder.equal(root.get("quantity"), quantity);
			}
		};
	}

	


	public static Specification<Product> createdtimeEqual(Date createdtime) {

		return (root, query, criteriaBuilder) -> {
			if (createdtime == null)
				return null;
			else {
				return criteriaBuilder.equal(root.get("createdtime"), createdtime);
			}
		};
	}

	public static Specification<Product> updatetimeEqual(Date updatetime) {

		return (root, query, criteriaBuilder) -> {
			if (updatetime == null)
				return null;
			else {
				return criteriaBuilder.equal(root.get("updatetime"), updatetime);
			}
		};
	}

	public static Specification<Product> supplierEqual(String supplier) {

		return (root, query, criteriaBuilder) -> {
			if (StringUtils.isEmpty(supplier))
				return null;
			else {
				return criteriaBuilder.equal(root.get("supplier"), supplier);
			}
		};
	}

	public static Specification<Product> vatEqual(Integer vat) {

		return (root, query, criteriaBuilder) -> {
			if (vat == null)
				return null;
			else {
				return criteriaBuilder.equal(root.get("vat"), vat);
			}
		};
	}

	public static Specification<Product> categoryEqual(Integer category) {

		return (root, query, criteriaBuilder) -> {
			if (category == null || category < 0)
				return null;
			else {
				return criteriaBuilder.equal(root.get("category"), category);
			}
		};
	}
	public static Specification<Product> categoryOr(List<Integer> categories) {

		return (root, query, criteriaBuilder) -> {
			if (categories == null || categories.size() < 0)
				return null;
			else {

				Predicate[] list=new Predicate[categories.size()];
				int index=0;
				for (Integer category : categories) {
					list[index]=criteriaBuilder.equal(root.<String>get("category"), category);
					index++;
				}
				return  criteriaBuilder.or(list);
			}
		};
	}
	public static Specification<Product> categoryListOr(List<Category> categories) {

		return (root, query, criteriaBuilder) -> {

			if (categories == null || categories.size() <= 0)
				return null;
			else {
				Predicate[] list=new Predicate[categories.size()];
				int index=0;
				for (Category category : categories) {
					list[index]=criteriaBuilder.equal(root.get("category"), category.getId());
					index++;
				}
				return  criteriaBuilder.or(list);
			}
		};
	}




	public static Specification<Product> orderByUpdateTime() {
		

		return (root, query, criteriaBuilder) -> {
			
			CriteriaQuery<?> orderBy = query.orderBy(criteriaBuilder.desc(root.get("updateTime")));	
			return null;
		};
	}

	public static Specification<Product> barCodeEqualTo(String barcode) {
		return (root, query, criteriaBuilder) -> {
			if (barcode == null ) {
				return null;
			}
			return criteriaBuilder.equal(root.get("barcode"), barcode);
		};
	}
}
