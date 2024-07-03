package kh.mclass.demo8;

import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@SpringBootTest
@WebAppConfiguration
class Demo8ApplicationTests {
	//Mock MVC - Controller 가능. service, repository 불가
	
	@Autowired
	private WebApplicationContext wac;  // 프로젝트객체를 받아서 사용함.
	
	private MockMvc mockMvc;  // 객체는 초기에 생성해서 사용해야함.
	
	private EmpService service;
//	private static EmpService service;
//	@BeforeAll   // JUnit 4의 @BeforeClass
//	static void setUp2() {
//		// 주로 service 객체 생성
//		service = new EmpService(); 
//		System.out.println("====== @BeforeAll");
//	}
	
	@AfterEach
	void tearDown() {
		System.out.println("=== @AfterEach");
	}
	@BeforeEach   // JUnit 4의 @Before
	void setUp() {
		// 주로 필요한 객체 생성
		
		//this.mockMvc = MockMvcBuilders.standaloneSetup(new Demo8Controller()).build();  // Demo8Controller 가지고 기본생성
		//this.service = new EmpService();  // Service 객체를 만들어서 사용 

		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();   // 프로젝트객체로 테스트MockMvc 객체를 생성

		System.out.println("=== @BeforeEach --- @Test 돌릴 준비완료");
	}
	@Test
	void gethome() {
		try {
			mockMvc
			.perform(    get("/home").param("findArea", "서울").param("page", "12")    )
			.andDo(print())
			.andExpect(status().isNotFound());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void empList() {
		try {
			mockMvc
			.perform(    get("/emp").param("ename", "SMITH")   )
			.andDo(print())
			.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void findemp() {
		try {
			mockMvc
			.perform(    get("/emp/find").param("ename", "SMITH")   )
			.andDo(print())
			.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	void insertemp() {
		try {
			mockMvc
			.perform(    post("/emp").param("ename", "SMITH").param("empno", "9999")    )
			.andDo(print())
			.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* Junit */
	@Test
	void contextLoads() {
		System.out.println("====== contextLoads");
		String a ="aaa";
		String b ="bbb";
		// 복잡한 코드가....
		Assertions.assertNotNull(a);
//		assertSame(a, b);
//		assertEquals(a, b);
//		assertTrue(a == b);
//		assertFalse(a == b);
//		assertNotNull(a);
//		assertArrayEquals(arr1, arr2);
	}
	@Test
	void contextLoads2() {
		System.out.println("====== contextLoads2");
		String a ="aaa";
		String b ="aaa";
		// 복잡한 코드가....
		assertEquals(a, b);
	}

}
