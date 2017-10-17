package edu.mum.dao.impl;

 

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.MemberDao;
import edu.mum.domain.Member;


@SuppressWarnings("unchecked")
@Repository
public class MemberDaoImpl extends GenericDaoImpl<Member> implements MemberDao {

	public MemberDaoImpl() {
		super.setDaoType(Member.class );
		}
	
	
//	public void save(Member member){
//		
//		String groupname=member.getUserCredentials().getUsername();
////	Query query=	entityManager.createNativeQuery("INSERT INTO Groups_CREDENTIALS(Groups_id,userCredentials_username) VALUES (1,jemal)");
////	   query.executeUpdate();
//	   entityManager.persist(member);
//	}

 
 }